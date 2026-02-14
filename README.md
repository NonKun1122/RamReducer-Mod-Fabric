# RAM Reducer Mod (Fabric 1.20.1 - 1.20.6)

มอดสำหรับลดการใช้ RAM ของมอดตัวอื่นๆ ใน Minecraft โดยใช้เทคนิคการจัดการหน่วยความจำขั้นสูง

## คุณสมบัติหลัก
- **Pre-Launch Loading:** โหลดตัวเองก่อนมอดอื่นๆ เพื่อเตรียมระบบจัดการ RAM
- **BlockState Deduplication:** ลดการใช้ RAM ในการเก็บข้อมูลสถานะบล็อก (คล้าย FerriteCore)
- **Model Predicate Caching:** แคชเงื่อนไขการแสดงผลโมเดลเพื่อลดการสร้าง Object ซ้ำซ้อน
- **String Interning:** ลด RAM จาก String ที่ซ้ำกันใน ResourceLocation และ Identifier
- **Lazy Asset Management:** ระบบจัดการการโหลด Asset ที่ชาญฉลาดขึ้น
- **Real-time Monitoring:** ติดตามการใช้ RAM และแจ้งเตือนเมื่อมีการใช้งานสูงเกินไป

## วิธีการติดตั้ง
1. ติดตั้ง Fabric Loader สำหรับเวอร์ชัน 1.20.1 - 1.20.6
2. นำไฟล์ `ram-reducer-1.0.0.jar` ไปใส่ในโฟลเดอร์ `mods`
3. เริ่มเกม

## การพัฒนา
โปรเจกต์นี้ใช้ Gradle ในการ Build:
```bash
./gradlew build
```
ไฟล์ JAR จะอยู่ที่ `build/libs/ram-reducer-1.0.0.jar`

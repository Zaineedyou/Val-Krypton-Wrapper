# Krypton Wrapper R9i Performance — Rilis Awal

## Status Rilis

Dokumen ini mendampingi build awal plugin **Krypton Wrapper R9i** untuk Zalith Launcher 2. Build ini adalah *fork* dari `BZLZHH/NGG-FCLRendererPlugin` dan menggunakan submodul `BZLZHH/NG-GL4ES` pada tag upstream `R0.4.5`.

Profil ini ditargetkan untuk **Realme 9i** dengan Snapdragon 680 / Adreno 610, Minecraft Java Edition **1.21.11**, dan **Fabric + Sodium**. Rilis ini belum mengklaim peningkatan FPS tertentu, karena angka FPS dan stabilitas harus divalidasi pada perangkat target dengan dunia, modpack, suhu, dan versi Zalith yang sama.

## Perubahan yang Diimplementasikan

| Area | Perubahan | Dasar Verifikasi |
|---|---|---|
| Identitas aplikasi | Application ID menjadi `com.manus.kryptonr9i`; nama aplikasi menjadi **Krypton Wrapper R9i**. | Menghindari menimpa plugin Krypton upstream saat dipasang bersamaan. |
| Profil renderer | Deskripsi plugin menandai **Krypton Wrapper R9i Performance (OpenGL 3.1+)**. | Metadata plugin dibaca oleh launcher kompatibel. |
| Backend | Mempertahankan `LIBGL_GL=31` dan `LIBGL_ES=3`. | Nilai tersebut merupakan konfigurasi default plugin upstream R0.4.5. |
| Kompatibilitas | Mempertahankan `LIBGL_NORMALIZE=1` dan `LIBGL_NOERROR=1`. | Nilai tersebut merupakan konfigurasi default plugin upstream R0.4.5. |
| Optimasi Tekstur Agresif | Menambahkan `LIBGL_SHRINK=1`. | Parser `NG-GL4ES/src/gl/texture.c` mengimplementasikan nilai ini untuk menurunkan resolusi semua tekstur menjadi setengahnya, mengurangi *memory bandwidth* GPU. |

> Build `0.1.2-brutal-1` ini menghapus `LIBGL_BATCH=1` (yang memicu crash pada v0.1.0) dan menggantinya dengan `LIBGL_SHRINK=1`. Ini adalah optimasi beban GPU, bukan CPU.

## Konfigurasi yang Harus Dipakai Saat Pengujian

Pengujian pertama harus menggunakan lingkungan yang terkendali agar hasilnya bisa dibandingkan dengan Krypton upstream.

| Komponen | Setelan Awal |
|---|---|
| Alokasi RAM Zalith | `-Xms1500M -Xmx2000M` |
| Minecraft | 1.21.11 |
| Loader | Fabric |
| Renderer mod | Sodium versi yang kompatibel dengan 1.21.11 |
| Mod pendamping minimum | Lithium dan FerriteCore, masing-masing versi yang kompatibel dengan 1.21.11 |
| Render distance | 6 chunk terlebih dahulu; naikkan ke 8 chunk hanya bila stabil |
| Simulation distance | 5 chunk |
| VSync | Off untuk pengukuran FPS; aktifkan lagi bila ingin membatasi panas/baterai |
| Shader | Off pada putaran benchmark performa dasar |

## Protokol Uji di Realme 9i

1. Catat FPS, waktu masuk dunia, dan apakah ada artefak dengan Krypton Wrapper upstream pada profil dan dunia yang sama.
2. Pasang **Krypton Wrapper R9i** tanpa menghapus plugin upstream, lalu pilih renderer R9i di Zalith Launcher 2.
3. Jalankan dunia yang sama selama 15 menit, termasuk bergerak cepat dan memuat chunk baru.
4. Ulangi pengujian pada render distance 6 dan 8 chunk. Jangan mengubah mod, RAM Java, resolusi, atau pengaturan lain di antara dua renderer.
5. Bila muncul crash, salin file `/sdcard/NGG/latest.log`, log latest dari Zalith, serta crash report Minecraft jika tersedia.
6. Bila tidak crash, ulangi selama 30 menit agar *stutter*, penggunaan memori, dan thermal throttling dapat diamati.

## Kriteria Keberhasilan Optimasi (v0.1.2-brutal-1)

Rilis ini dianggap sukses jika:
1. FPS di area sepi naik menembus 70 FPS karena beban *texture fetch* GPU berkurang drastis.
2. Tidak terjadi crash saat merender *chunk* baru (seperti pada v0.1.1).
3. Penurunan kualitas tekstur (karena di-*shrink* setengahnya) masih dapat ditoleransi secara visual.

Jika tekstur terlihat terlalu buram tetapi FPS naik, iterasi selanjutnya akan menggunakan `LIBGL_SHRINK=2` (hanya mengecilkan tekstur besar).

## Batasan yang Diketahui

Build sandbox hanya dapat memverifikasi bahwa APK dan library ARM64 berhasil dikompilasi. Sandbox tidak memiliki Realme 9i, driver Adreno 610, atau sesi Zalith pengguna, sehingga validasi kinerja dan stabilitas perangkat wajib dilakukan di HP target.

## Sumber Utama

1. [NG-GL4ES / Krypton Wrapper](https://github.com/BZLZHH/NG-GL4ES)
2. [NGG-FCLRendererPlugin](https://github.com/BZLZHH/NGG-FCLRendererPlugin)
3. [Dokumentasi kompilasi NG-GL4ES](https://github.com/BZLZHH/NG-GL4ES/blob/main/COMPILE.md)
4. [Dokumentasi SDK Manager Android](https://developer.android.com/tools/sdkmanager)

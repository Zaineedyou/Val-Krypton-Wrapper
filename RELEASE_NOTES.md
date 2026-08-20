# Val-Krypton-Wrapper v0.1.2-brutal-1

## Target

Build ini ditargetkan untuk **Realme 9i** dengan Snapdragon 680 / Adreno 610, Zalith Launcher 2, Minecraft Java Edition 1.21.11, Fabric, dan Sodium.

## Perubahan

| Versi | Perubahan | Hasil uji pengguna |
|---|---|---|
| `0.1.0-dev` | Menambahkan `LIBGL_BATCH=1` | Tidak stabil; crash `SIGSEGV` pada `glDrawElements`. |
| `0.1.1-stability` | Menghapus `LIBGL_BATCH=1` | Stabil: 30–60 FPS di area mob ramai; ~70 FPS di area sepi. |
| `0.1.2-brutal-1` | Menambahkan `LIBGL_SHRINK=1` | FPS 80–100 saat gerak/diam, hingga 180 saat memuat chunk, dan 50–70 FPS di area mob ramai menurut pengujian Zaineedyou. |

## Konfigurasi Uji yang Dilaporkan

Pengujian performa di atas dilakukan dengan konfigurasi berikut:

* Zalith render resolution: **65%**.
* Mod Render Scale: **45%**.
* Resource pack custom: lebih dari **30 MB**.
* Minecraft 1.21.11 dengan Fabric + Sodium.

> `LIBGL_SHRINK=1` menurunkan resolusi tekstur internal menjadi setengahnya. Hasil FPS tinggi harus dipahami sebagai efek gabungan dari texture shrink dan resolusi render yang sangat rendah; kualitas tekstur dapat terlihat lebih lunak/buram.

## Pemasangan

1. Unduh `Val-Krypton-Wrapper-v0.1.2-brutal-1.apk` dari direktori `releases/`.
2. Pasang atau timpa APK versi sebelumnya.
3. Di Zalith Launcher 2, pilih **Krypton Wrapper R9i Performance (OpenGL 3.1+)**.
4. Uji di dunia yang sama sebelum membandingkan FPS.

## Known Issues

* `LIBGL_BATCH` tidak digunakan karena memicu crash pada Sodium/Minecraft 1.21.11 di Realme 9i.
* ANGLE sengaja tidak digunakan dalam profil ini; renderer berjalan langsung melalui backend OpenGL ES 3.
* Kualitas tekstur dapat turun akibat `LIBGL_SHRINK=1`.

Val-Krypton-Wrapper
====

> **Public Realme 9i performance fork maintained by [Zaineedyou](https://github.com/Zaineedyou).**
>
> This project is developed with implementation and documentation assistance from **Manus AI**. See [AUTHORS.md](AUTHORS.md) for complete attribution.

This is a public fork of the **plugin application** for *Fold Craft Launcher*, *Zalith Launcher*, and *Pojav·Glow·Worm* to use Krypton Wrapper. It preserves upstream licensing and credits while adding tested Realme 9i (Snapdragon 680 / Adreno 610) profiles.

## Current Release

**v0.1.6-brutal-5** is distributed at [`releases/Val-Krypton-Wrapper-v0.1.6-brutal-5.apk`](releases/Val-Krypton-Wrapper-v0.1.6-brutal-5.apk). It retains the `LIBGL_SHRINK=1` texture optimization, disables V-Sync for uncapped frames, and enables internal texture copies (`LIBGL_TEXCOPY=1`) to speed up texture updates. Read [RELEASE_NOTES.md](RELEASE_NOTES.md) before installing.


If you want to learn more about **Krypton Wrapper**, please see [NG-GL4ES](https://github.com/BZLZHH/NG-GL4ES).

License
====

MIT License.

Please see [LICENSE](https://github.com/BZLZHH/NGG-FCLRendererPlugin/blob/main/LICENSE).

Third party components
====

Here are the third-party components that this plugin application is using (**NOT Krypton Wrapper**):
[LICENSE](LICENSE)
**OkHttp** by **Square**: [github](https://github.com/square/okhttp)

**JSON-java** by **stleary**: [github](https://github.com/stleary/JSON-java)

**Markwon Core** by **Noties**: [github](https://github.com/noties/Markwon)

**Markwon Strikethrough Extension** by **Noties**: [github](https://github.com/noties/Markwon)

**Kotlin Standard Library** by **JetBrains**: [github](https://github.com/JetBrains/kotlin)

**Kotlin Coroutines Core** by **Kotlinx**: [github](https://github.com/Kotlin/kotlinx.coroutines)

**Kotlin Coroutines Android** by **Kotlinx**: [github](https://github.com/Kotlin/kotlinx.coroutines)

**AndroidX Core** by **Google**: [github](https://github.com/androidx/androidx)

What's more, this project also mentions [ANGLE](https://github.com/google/angle) by **Google**, but it does **NOT** provide it.

**(See [NG-GL4ES](https://github.com/BZLZHH/NG-GL4ES) to check what third-party components Krypton Wrapper is using)**

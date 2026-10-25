# Expanded Delight — Fabric 26.2 移植版

[Expanded Delight](https://www.curseforge.com/minecraft/mc-mods/expanded-delight)（Farmer's Delight 附属模组）的
**Minecraft 26.2 + Fabric** 移植，基于官方仓库的 `1.21-fabric` 分支。

## 状态

| 项目 | 状态 |
| --- | --- |
| `gradle build` | ✅ 通过 |
| 服务端（装 Farmer's Delight Refabricated 26.2） | ✅ 45 个模组、2001 个配方、**0 ERROR** |
| 服务端（不装 FD） | ✅ 给出清晰的依赖提示（本模组是 FD 附加，必须装 FD） |
| 内容 | ✅ 作物（芦笋/红薯/辣椒/花生/蔓越莓/肉桂）、食物饮料、木桶奶酪、榨汁机、箱子、肉桂木套装（含船/告示牌/橱柜） |
| 已知外观 TODO | 榨汁机 GUI 暂用标准容器界面；船暂用橡木贴图 |

## 需要什么

- Minecraft **26.2**
- Fabric Loader **≥ 0.19.5**
- Fabric API **0.161.0+26.2**
- **Farmer's Delight Refabricated 26.2**（必需，重织版）
- Java **25**

## 构建

```bash
./gradlew build        # 产物在 build/libs/
./gradlew runServer    # 开发服务器（run/mods 里放 FD 的 jar）
./gradlew runClient
```

工程使用 Loom 1.18.4 / Gradle 9.7.1，Minecraft 26.2 无需 mappings。
FD 的 jar 放在 `libs/` 仅用于编译（运行时由 mods 文件夹提供）。

## 与原版的差异

- 村民交易改为 26.2 的数据驱动 JSON（`data/expandeddelight/villager_trade/...`）
- 世界生成用 Fabric `BiomeModifications` 替代 NeoForge 的 biome modifier JSON
- 自定义树叶生成器换成原版金合欢生成器（26.2 的 FoliagePlacer API 重写）
- 榨汁机配方改用 `ItemStackTemplate`（26.2 配方产物必须是模板）
- 删除了 create / farmersrespite / sereneseasons / supplementaries / toughasnails 的兼容数据

## 许可

原模组为 CC0-1.0，本移植同样以 CC0-1.0 发布。

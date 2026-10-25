# Expanded Delight → Fabric 26.2 移植：进展与评估

## 已完成

1. 选定上游：`ianm1647/expandeddelight` 的 **1.21-fabric** 分支（官方仓库里唯一的 Fabric 版，1.21.1，依赖 Farmer's Delight Refabricated）。
2. 建立 26.2 工程骨架：Loom 1.18.4 / Gradle 9.7.1 / Java 25 / MC 26.2 / Fabric API 0.161.0+26.2 / Loader 0.19.5。
3. 打通构建：Loom 已能正确生成 26.2 的 client/common 拆分 jar（access widener 命名空间改成 `official`、启用 `splitEnvironmentSourceSets`）。
4. 把客户端源码拆到 `src/client`，删掉不再需要的 Fabric-ASM 早期加载器。
5. 批量迁移：`ResourceLocation` → `Identifier`、`level.random` → `getRandom()`、`isClientSide` → `isClientSide()`。

## 当前状态：✅ 构建通过 + 服务端跑通（第 7 轮结束）

- `gradle build` 成功，产出 `build/libs/expandeddelight-1.0.0+26.2.jar`
- **装 Farmer's Delight Refabricated 26.2**：服务端 **Done**，45 个模组、2001 个配方、**0 ERROR**
- **不装 FD**：Fabric 给出清晰的依赖错误「需要 farmersdelight，但没有安装它」（附加模组的正确行为）

第 7 轮完成：
- 生成 99 个 26.2 的 `items/*.json`（物品模型定义）
- 103 个配方转成 26.2 材料格式（字符串 / `#tag`）
- 4 个野生作物战利品表去掉 NeoForge 条件，改用原版 `match_tool`（剪刀）
- 删除 `neoforge/` 数据、`loot_modifiers`、以及 create/farmersrespite/sereneseasons/supplementaries/toughasnails 的兼容数据
- 用 Fabric `BiomeModifications` 替代 NeoForge 的 biome_modifier JSON（7 处）
- worldgen JSON 适配 26.2：树配置（`below_trunk_provider`、原版金合欢树叶生成器）、5 个 patch 改成 `simple_block` + `would_survive`
- 方块/物品注册补 `setId(ResourceKey)`（26.2 必需），注册顺序修正（实体类型要先于物品）
- 榨汁机配方改用 `ItemStackTemplate`（26.2 配方不能用 `ItemStack.CODEC`，否则报 "components not bound"）
- 村民交易改为数据驱动 JSON（农夫 1/2 级）

待办（第 8 轮）：
1. 发布到 GitHub（建仓库、推送、Release）
2. 补榨汁机 GUI 的自定义背景/进度条（当前是标准容器界面）
3. 船暂时借橡木贴图渲染
4. README / CHANGELOG / 移植说明

## 原始评估（第 0 轮）：524 个错误

按类型统计（前 20）：

| 数量 | 问题 | 26.2 的变化 |
| --- | --- | --- |
| ~20 | `ItemInteractionResult` | 已删除，统一用 `InteractionResult` |
| ~14 | `InteractionResultHolder<ItemStack>` | 已删除，`Item#use` 直接返回 `InteractionResult` |
| ~30 | 配方书（RecipeBook）相关 | `RecipeBookMenu` 去掉泛型；配方书分类需改；本工程整套配方书实现已删除 |
| ~20 | 方块实体存读档 | 26.2 用 `ValueInput`/`ValueOutput` 取代 `CompoundTag` |
| ~8 | `net.minecraft.world.entity.vehicle.Boat` | 包名改为 `...vehicle.boat.Boat` |
| ~8 | `TradeOfferHelper`（Fabric） | 包已从 26.2 的 Fabric API 移除，改用原版 `VillagerTrades` |
| ~4 | `ExtendedScreenHandlerFactory` | 改为 `net.fabricmc.fabric.api.menu.v1.FabricMenuProvider` |
| ~8 | 树叶生成器参数 | `LevelSimulatedReader` → `WorldGenLevel` |
| 其余 | 各种签名/字段变化 | 需要逐个对照 26.2 源码 |

## 为什么这次比上一个模组难得多

| | Cultural Delights | Expanded Delight |
| --- | --- | --- |
| Java 规模 | 1,600 行 / 22 文件 | **4,700 行 / 72 文件** |
| 图形界面 | 无 | 榨汁机 GUI + 菜单 + 自定义配方类型 |
| 方块实体 | 无 | 榨汁机、橱柜、告示牌 |
| 上游状态 | 稳定版 | **1.21-fabric 分支是 WIP**（提交信息里写着 "buggy juicer"，`fabric.mod.json` 还是模板） |

## 两条路线

### 路线 A：完整移植（推荐，但需要多轮）

保留榨汁机 GUI、区块实体、船、告示牌、橱柜等全部内容，逐项适配 26.2。
预计：还需要 **约 10-20 轮** 构建-修错迭代，外加数据转换与两套环境测试。

### 路线 B：先做内容版（约 3-5 轮）

- 保留：作物（花生/肉桂/辣椒/蔓越莓等）、食物、饮料、木桶/奶酪、箱子、肉桂树世界生成、配方、全部贴图/模型。
- 暂缓：榨汁机 GUI、船、告示牌、橱柜。
- 榨汁机先做成"右键即时榨汁"的简化方块（配方仍然生效，只是没有界面）。
- 之后在路线 A 里把 GUI 补回来。

## 现在能用的东西

- 工程：`ed-26.2/`
- Farmer's Delight 26.2 的 jar 已放进 `ed-26.2/libs/`（仅编译用，运行时装 mods）
- 构建命令：`gradle build`（当前会停在编译错误，属预期）

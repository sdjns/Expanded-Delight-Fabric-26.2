# Expanded Delight → Fabric 26.2 移植：进展与评估

## 已完成

1. 选定上游：`ianm1647/expandeddelight` 的 **1.21-fabric** 分支（官方仓库里唯一的 Fabric 版，1.21.1，依赖 Farmer's Delight Refabricated）。
2. 建立 26.2 工程骨架：Loom 1.18.4 / Gradle 9.7.1 / Java 25 / MC 26.2 / Fabric API 0.161.0+26.2 / Loader 0.19.5。
3. 打通构建：Loom 已能正确生成 26.2 的 client/common 拆分 jar（access widener 命名空间改成 `official`、启用 `splitEnvironmentSourceSets`）。
4. 把客户端源码拆到 `src/client`，删掉不再需要的 Fabric-ASM 早期加载器。
5. 批量迁移：`ResourceLocation` → `Identifier`、`level.random` → `getRandom()`、`isClientSide` → `isClientSide()`。

## 当前状态：✅ 已发布（第 8 轮结束）

- 构建：`gradle build` 通过
- 服务端：装 FD 26.2 时 45 模组 / 2001 配方 / 0 ERROR；不装时给出清晰依赖提示
- 仓库：https://github.com/sdjns/Expanded-Delight-Fabric-26.2
- 发布：https://github.com/sdjns/Expanded-Delight-Fabric-26.2/releases/tag/v1.0.0%2B26.2
- 仓库包含 1048 个文件（第三方 FD jar 已从仓库移除，构建前需自备到 `libs/`）

剩余（外观，不影响功能）：
1. 榨汁机界面自定义背景 + 进度条
2. 船的自定义贴图
3. 流浪商人交易（需要补 trade tags，暂未启用）
4. 客户端画面未实机验证

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

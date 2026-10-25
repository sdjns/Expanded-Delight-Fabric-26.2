package ianm1647.expandeddelight.common.registry;

import ianm1647.expandeddelight.common.block.*;
import ianm1647.expandeddelight.common.utility.RegUtils;
import ianm1647.expandeddelight.common.world.tree.EDTreeGrowers;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import vectorwing.farmersdelight.common.block.PieBlock;
import vectorwing.farmersdelight.common.block.WildCropBlock;

import java.util.function.Supplier;

public class EDBlocks {

    public static Supplier<Block> CINNAMON_SAPLING;
    public static Supplier<Block> CINNAMON_LEAVES;
    public static Supplier<Block> CINNAMON_LOG;
    public static Supplier<Block> CINNAMON_WOOD;
    public static Supplier<Block> CINNAMON_STRIPPED_LOG;
    public static Supplier<Block> CINNAMON_STRIPPED_WOOD;
    public static Supplier<Block> CINNAMON_PLANKS;
    public static Supplier<Block> CINNAMON_STAIRS;
    public static Supplier<Block> CINNAMON_SLAB;
    public static Supplier<Block> CINNAMON_FENCE;
    public static Supplier<Block> CINNAMON_FENCE_GATE;
    public static Supplier<Block> CINNAMON_DOOR;
    public static Supplier<Block> CINNAMON_TRAPDOOR;
    public static Supplier<Block> CINNAMON_PRESSURE_PLATE;
    public static Supplier<Block> CINNAMON_BUTTON;
    public static Supplier<Block> CINNAMON_SIGN;
    public static Supplier<Block> CINNAMON_WALL_SIGN;
    public static Supplier<Block> CINNAMON_CEILING_HANGING_SIGN;
    public static Supplier<Block> CINNAMON_WALL_HANGING_SIGN;
    public static Supplier<Block> CINNAMON_CABINET;

    public static Supplier<Block> JUICER;
    public static Supplier<Block> CASK;
    public static Supplier<Block> MILK_CASK;
    public static Supplier<Block> GOAT_MILK_CASK;
    public static Supplier<Block> CHEESE_CASK;
    public static Supplier<Block> GOAT_CHEESE_CASK;

    public static Supplier<Block> CHEESE_WHEEL;
    public static Supplier<Block> GOAT_CHEESE_WHEEL;

    public static Supplier<Block> ASPARAGUS_CRATE;
    public static Supplier<Block> SWEET_POTATO_CRATE;
    public static Supplier<Block> CHILI_PEPPER_CRATE;
    public static Supplier<Block> CRANBERRY_BAG;

    public static Supplier<Block> WILD_ASPARAGUS;
    public static Supplier<Block> WILD_SWEET_POTATO;
    public static Supplier<Block> WILD_CHILI_PEPPER;
    public static Supplier<Block> WILD_PEANUTS;

    public static Supplier<Block> SALT_ORE;
    public static Supplier<Block> DEEPSLATE_SALT_ORE;

    public static Supplier<Block> ASPARAGUS_CROP;
    public static Supplier<Block> SWEET_POTATO_CROP;
    public static Supplier<Block> CHILI_PEPPER_CROP;
    public static Supplier<Block> PEANUT_CROP;

    public static Supplier<Block> CRANBERRY_PLANT;
    public static Supplier<Block> CRANBERRY_COBBLER;
    public static Supplier<Block> HONEYED_GOAT_CHEESE_TART;

    public EDBlocks() {}

    public static void register() {
        CINNAMON_SAPLING = RegUtils.regBlock("cinnamon_sapling",
                key -> new SaplingBlock(EDTreeGrowers.CINNAMON, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).setId(key)));
        CINNAMON_LEAVES = RegUtils.regBlock("cinnamon_leaves",
                key -> new CinnamonLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).setId(key)));
        CINNAMON_LOG = RegUtils.regBlock("cinnamon_log",
                key -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(key)));
        CINNAMON_WOOD = RegUtils.regBlock("cinnamon_wood",
                key -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(key)));
        CINNAMON_STRIPPED_LOG = RegUtils.regBlock("stripped_cinnamon_log",
                key -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).setId(key)));
        CINNAMON_STRIPPED_WOOD = RegUtils.regBlock("stripped_cinnamon_wood",
                key -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).setId(key)));
        CINNAMON_PLANKS = RegUtils.regBlock("cinnamon_planks",
                key -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(key)));
        CINNAMON_STAIRS = RegUtils.regBlock("cinnamon_stairs",
                key -> new StairBlock(CINNAMON_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).setId(key)));
        CINNAMON_SLAB = RegUtils.regBlock("cinnamon_slab",
                key -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).setId(key)));
        CINNAMON_FENCE = RegUtils.regBlock("cinnamon_fence",
                key -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).setId(key)));
        CINNAMON_FENCE_GATE = RegUtils.regBlock("cinnamon_fence_gate",
                key -> new FenceGateBlock(EDWoodTypes.CINNAMON, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).setId(key)));
        CINNAMON_DOOR = RegUtils.regBlock("cinnamon_door",
                key -> new DoorBlock(EDWoodTypes.CINNAMON.setType(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).setId(key)));
        CINNAMON_TRAPDOOR = RegUtils.regBlock("cinnamon_trapdoor",
                key -> new TrapDoorBlock(EDWoodTypes.CINNAMON.setType(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).setId(key)));
        CINNAMON_PRESSURE_PLATE = RegUtils.regBlock("cinnamon_pressure_plate",
                key -> new PressurePlateBlock(EDWoodTypes.CINNAMON.setType(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).setId(key)));
        CINNAMON_BUTTON = RegUtils.regBlock("cinnamon_button",
                key -> new ButtonBlock(EDWoodTypes.CINNAMON.setType(), 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(key)));
        CINNAMON_SIGN = RegUtils.regBlock("cinnamon_sign", CinnamonStandingSignBlock::new);
        CINNAMON_WALL_SIGN = RegUtils.regBlock("cinnamon_wall_sign", CinnamonWallSignBlock::new);
        CINNAMON_CEILING_HANGING_SIGN = RegUtils.regBlock("cinnamon_ceiling_hanging_sign", CinnamonCeilingHangingSignBlock::new);
        CINNAMON_WALL_HANGING_SIGN = RegUtils.regBlock("cinnamon_wall_hanging_sign", CinnamonWallHangingSignBlock::new);
        CINNAMON_CABINET = RegUtils.regBlock("cinnamon_cabinet", CinnamonCabinetBlock::new);

        JUICER = RegUtils.regBlock("juicer",
                key -> new JuicerBlock(BlockBehaviour.Properties.of().setId(key).mapColor(MapColor.WOOD).strength(0.5F, 1.0F).sound(SoundType.BAMBOO_WOOD)));
        CASK = RegUtils.regBlock("cask",
                    key -> new CaskBlock(BlockBehaviour.Properties.of().setId(key).mapColor(MapColor.WOOD).strength(1.0F, 1.0F).sound(SoundType.CHERRY_WOOD)));
        MILK_CASK = RegUtils.regBlock("milk_cask",
                    key -> new MilkCaskBlock(BlockBehaviour.Properties.of().setId(key).mapColor(MapColor.WOOD).strength(1.0F, 1.0F).sound(SoundType.CHERRY_WOOD)));
        CHEESE_CASK = RegUtils.regBlock("cheese_cask",
                    key -> new CheeseCaskBlock(BlockBehaviour.Properties.of().setId(key).mapColor(MapColor.WOOD).strength(1.0F, 1.0F).sound(SoundType.CHERRY_WOOD)));
        GOAT_MILK_CASK = RegUtils.regBlock("goat_milk_cask",
                key -> new MilkCaskBlock(BlockBehaviour.Properties.of().setId(key).mapColor(MapColor.WOOD).strength(1.0F, 1.0F).sound(SoundType.CHERRY_WOOD)));
        GOAT_CHEESE_CASK = RegUtils.regBlock("goat_cheese_cask",
                key -> new CheeseCaskBlock(BlockBehaviour.Properties.of().setId(key).mapColor(MapColor.WOOD).strength(1.0F, 1.0F).sound(SoundType.CHERRY_WOOD)));
        CHEESE_WHEEL = RegUtils.regBlock("cheese_wheel",
                    key -> new PieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE).setId(key), EDItems.CHEESE_SLICE));
        GOAT_CHEESE_WHEEL = RegUtils.regBlock("goat_cheese_wheel",
                key -> new PieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE).setId(key), EDItems.GOAT_CHEESE_SLICE));

        ASPARAGUS_CRATE = RegUtils.regBlock("asparagus_crate",
                key -> new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(key)));
        SWEET_POTATO_CRATE = RegUtils.regBlock("sweet_potato_crate",
                key -> new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(key)));
        CHILI_PEPPER_CRATE = RegUtils.regBlock("chili_pepper_crate",
                key -> new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(key)));
        CRANBERRY_BAG = RegUtils.regBlock("cranberry_bag",
                key -> new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.red()).setId(key)));

        WILD_ASPARAGUS  = RegUtils.regBlock("wild_asparagus",
                key -> new EDWildCropBlock(MobEffects.ABSORPTION, 6, BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS).setId(key)));
        WILD_SWEET_POTATO  = RegUtils.regBlock("wild_sweet_potato",
                key -> new EDWildCropBlock(MobEffects.OOZING, 6, BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS).setId(key)));
        WILD_CHILI_PEPPER  = RegUtils.regBlock("wild_chili_pepper",
                key -> new EDWildCropBlock(MobEffects.NAUSEA, 6, BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS).setId(key)));
        WILD_PEANUTS  = RegUtils.regBlock("wild_peanuts",
                key -> new EDWildCropBlock(MobEffects.RESISTANCE, 6, BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS).setId(key)));

        SALT_ORE = RegUtils.regBlock("salt_ore",
                key -> new DropExperienceBlock(UniformInt.of(0, 2), BlockBehaviour.Properties.of().setId(key).mapColor(MapColor.STONE)
                        .strength(3.0f, 3.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
        DEEPSLATE_SALT_ORE = RegUtils.regBlock("deepslate_salt_ore",
                key -> new DropExperienceBlock(UniformInt.of(0, 2), BlockBehaviour.Properties.of().setId(key).mapColor(MapColor.STONE)
                        .strength(4.5f, 3.0f).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops()));

        CRANBERRY_PLANT = RegUtils.regBlock("cranberry_plant",
                key -> new CranberryPlantBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LILY_PAD).setId(key).mapColor(MapColor.PLANT).sound(SoundType.LILY_PAD)));
        CRANBERRY_COBBLER = RegUtils.regBlock("cranberry_cobbler",
                key -> new PieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE).setId(key), EDItems.CRANBERRY_COBBLER_SLICE));
        HONEYED_GOAT_CHEESE_TART = RegUtils.regBlock("honeyed_goat_cheese_tart",
                key -> new PieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE).setId(key), EDItems.HONEYED_GOAT_CHEESE_TART_SLICE));

        ASPARAGUS_CROP = RegUtils.regBlock("asparagus_crop", EDCropBlock::new);
        SWEET_POTATO_CROP = RegUtils.regBlock("sweet_potato_crop", EDCropBlock::new);
        CHILI_PEPPER_CROP = RegUtils.regBlock("chili_pepper_crop", EDCropBlock::new);
        PEANUT_CROP = RegUtils.regBlock("peanut_crop", EDCropBlock::new);
    }
}

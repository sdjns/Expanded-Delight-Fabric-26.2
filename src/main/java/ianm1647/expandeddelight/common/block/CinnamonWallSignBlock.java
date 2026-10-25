package ianm1647.expandeddelight.common.block;

import ianm1647.expandeddelight.common.registry.EDBlockEntityTypes;
import ianm1647.expandeddelight.common.registry.EDWoodTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CinnamonWallSignBlock extends WallSignBlock {
    public CinnamonWallSignBlock(net.minecraft.resources.ResourceKey<Block> key) {
        super(EDWoodTypes.CINNAMON, Properties.ofFullCopy(Blocks.SPRUCE_SIGN).setId(key));
    }

    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return EDBlockEntityTypes.CINNAMON_SIGN.get().create(pos, state);
    }
}

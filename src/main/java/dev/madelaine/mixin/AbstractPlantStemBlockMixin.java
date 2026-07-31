package dev.madelaine.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.GrowingPlantBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.NonNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(GrowingPlantHeadBlock.class)
public abstract class AbstractPlantStemBlockMixin extends GrowingPlantBlock {
    protected AbstractPlantStemBlockMixin(BlockBehaviour.Properties properties, Direction growthDirection, VoxelShape shape, boolean scheduleFluidTicks) {
        super(properties, growthDirection, shape, scheduleFluidTicks);
    }

    @Shadow
    protected abstract void randomTick(@NonNull BlockState state, @NonNull ServerLevel level, @NonNull BlockPos pos, @NonNull RandomSource random);

    @Override
    protected void tick(@NonNull BlockState state, @NonNull ServerLevel level, @NonNull BlockPos pos, @NonNull RandomSource random) {
        this.randomTick(state, level, pos, random);
    }
}

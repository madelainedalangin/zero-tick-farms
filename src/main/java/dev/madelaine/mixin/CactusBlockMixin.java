package dev.madelaine.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.CactusBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

//Minecraft 2025 makes the cactus grow and this mod will make that
//happen given the right conditions.
//Using an observer pointing to the cactus will also constantly update the cactus,
// and make it grow.
@Mixin(CactusBlock.class)
public abstract class CactusBlockMixin {
    @Shadow
    protected abstract void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random);

    @Inject(method = "tick", at = @At("HEAD"))
    private void zeroTickGrowth(BlockState state, ServerLevel level, BlockPos pos, RandomSource random, CallbackInfo ci) {
        this.randomTick(state, level, pos, random);
    }
}

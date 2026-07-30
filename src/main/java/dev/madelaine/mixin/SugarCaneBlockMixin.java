package dev.madelaine.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.SugarCaneBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SugarCaneBlock.class)
public abstract class SugarCaneBlockMixin {
    @Shadow
    protected abstract void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random);

    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    private void zeroTickGrowth(BlockState state, ServerLevel level, BlockPos pos, RandomSource random, CallbackInfo ci) {
        this.randomTick(state, level, pos, random);
        //skips vanilla's survival check so that the piston do not break the sugar cane
        //the side effect is that the sugarcane grows even without water and does not
        //self-destruct when no water is adjacent to it.
        ci.cancel();
    }
}

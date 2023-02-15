package io.github.samthegamer39.railroadblocks.mixin;

import io.github.samthegamer39.railroadblocks.RailroadBlocks;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Mixins are not implemented in this mod.
 */
@Mixin(TitleScreen.class)
public class ExampleMixin {

    /**
     * This function is not implemented.
     * @param info Not used.
     */
    @Inject(at = @At("HEAD"), method = "init()V")
    private void init(CallbackInfo info) {

    }
}

package com.terraformersmc.cinderscapesold.surfacebuilder.config;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.surfacebuilder.SurfaceConfig;

/**
 * [REVIEWED]
 *
 * An empty surface configuration for surface builders that implement entirely their own logic
 *
 * @author <Wtoll> Will Toll on 2020-05-02
 * @project Cinderscapes
 */
public class EmptySurfaceConfig implements SurfaceConfig {

    public EmptySurfaceConfig() {

    }

    @Override
    public BlockState getTopMaterial() {
        return null;
    }

    @Override
    public BlockState getUnderMaterial() {
        return null;
    }

    public static final Codec<EmptySurfaceConfig> CODEC = Codec.unit(() -> null);
}

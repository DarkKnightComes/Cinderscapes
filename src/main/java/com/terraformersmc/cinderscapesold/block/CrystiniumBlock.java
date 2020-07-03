package com.terraformersmc.cinderscapesold.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

/**
 * @author <Wtoll> Will Toll on 2020-06-06
 * @project Cinderscapes
 */
public class CrystiniumBlock extends CinderscapesNetherPlantBlock {
    public CrystiniumBlock() {
        super(FabricBlockSettings.copy(Blocks.WARPED_ROOTS), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0));
    }

    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextFloat() > 0.8) {
            world.addParticle(ParticleTypes.FIREWORK, pos.getX() + random.nextFloat(), pos.getY() + random.nextFloat(), pos.getZ() + random.nextFloat(), random.nextFloat() * 0.1 - 0.05, random.nextFloat() * 0.1 - 0.05, random.nextFloat() * 0.1 - 0.05);
        }
    }
}

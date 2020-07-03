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
public class PyracinthBlock extends CinderscapesNetherPlantBlock {
    public PyracinthBlock() {
        super(FabricBlockSettings.copy(Blocks.WARPED_ROOTS), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0));
    }

    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        world.addParticle(ParticleTypes.SMOKE, pos.getX() + random.nextFloat(), pos.getY() + random.nextFloat(), pos.getZ() + random.nextFloat(), random.nextFloat() * 0.1 - 0.05, random.nextFloat() * 0.1 - 0.05, random.nextFloat() * 0.1 - 0.05);
        if (random.nextFloat() > 0.6) {
            world.addParticle(ParticleTypes.FLAME, pos.getX() + 0.4f + random.nextFloat() * 0.2f, pos.getY() + 0.5f, pos.getZ() + 0.4f + random.nextFloat() * 0.2f, 0.0f, 0.05f, 0.0f);
        }
    }
}

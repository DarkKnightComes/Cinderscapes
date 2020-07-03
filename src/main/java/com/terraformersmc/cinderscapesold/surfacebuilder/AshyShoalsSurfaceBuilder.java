package com.terraformersmc.cinderscapesold.surfacebuilder;

import com.terraformersmc.cinderscapesold.surfacebuilder.config.EmptySurfaceConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

import java.util.Random;

/**
 * @author <Wtoll> Will Toll on 2020-05-23
 * @project Cinderscapes
 */
public class AshyShoalsSurfaceBuilder extends SurfaceBuilder<EmptySurfaceConfig> {
    public AshyShoalsSurfaceBuilder() {
        super(EmptySurfaceConfig.CODEC);
    }

    @Override
    public void generate(Random random, Chunk chunk, Biome biome, int x, int z, int height, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, EmptySurfaceConfig surfaceBlocks) {
        for (int y = 0; y < 256; y++) {
            BlockPos pos = new BlockPos(x & 15, y, z & 15);
            BlockState state = chunk.getBlockState(pos);
            if (state.getBlock() == defaultBlock.getBlock()) {
                chunk.setBlockState(pos, Blocks.NETHERRACK.getDefaultState(), false);
            } else if (state.getBlock() == defaultFluid.getBlock()) {
                if (chunk.getBlockState(pos.up()).isAir()) {
                    chunk.setBlockState(pos, Blocks.MAGMA_BLOCK.getDefaultState(), false);
                } else {
                    chunk.setBlockState(pos, Blocks.NETHERRACK.getDefaultState(), false);
                }
            }
        }
    }
}

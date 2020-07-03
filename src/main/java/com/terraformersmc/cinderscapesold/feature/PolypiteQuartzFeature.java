package com.terraformersmc.cinderscapesold.feature;

import com.terraformersmc.cinderscapesold.feature.config.PolypiteQuartzFeatureConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author <Wtoll> Will Toll on 2020-06-06
 * @project Cinderscapes
 */
public class PolypiteQuartzFeature extends Feature<PolypiteQuartzFeatureConfig> {
    public PolypiteQuartzFeature() {
        super(PolypiteQuartzFeatureConfig.CODEC);
    }

    @Override
    public boolean generate(ServerWorldAccess world, StructureAccessor accessor, ChunkGenerator generator, Random random, BlockPos pos, PolypiteQuartzFeatureConfig config) {
        if (world.isAir(pos)) {
            List<Direction> valid_faces = new ArrayList<>();
            for (Direction dir : Direction.values()) {
                BlockPos placeOnPos = pos.offset(dir);
                BlockState placeOnState = world.getBlockState(placeOnPos);
                if (placeOnState.isOf(Blocks.NETHERRACK)) {
                    valid_faces.add(dir);
                }
            }
            if (!valid_faces.isEmpty()) {
                Direction setDir = valid_faces.get(random.nextInt(valid_faces.size()));
                world.setBlockState(pos, config.quartzMaterial.stateOf(setDir), 0);
                return true;
            }
        }
        return false;
    }
}

package com.rushil.cosmic;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.Commands;

public class CosmicCivilization implements ModInitializer {
    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(Commands.literal("cosmic")
                .then(Commands.literal("rocket").executes(context ->
                    spawnRocket(context.getSource().getPlayerOrException())))
                .then(Commands.literal("space").executes(context -> {
                    context.getSource().sendSuccess(
                        () -> Component.literal("Space Dimension is not implemented yet."),
                        false
                    );
                    return 1;
                }))
            );
        });
    }

    private static int spawnRocket(ServerPlayer player) {
        BlockPos origin = player.blockPosition().offset(2, 0, 0);
        var level = player.level();

        place(level, origin, Blocks.IRON_BLOCK);
        place(level, origin.above(), Blocks.IRON_BLOCK);
        place(level, origin.above(2), Blocks.IRON_BLOCK);
        place(level, origin.above(3), Blocks.IRON_BLOCK);
        place(level, origin.above(4), Blocks.GLASS);
        place(level, origin.above(5), Blocks.IRON_BLOCK);
        place(level, origin.offset(1, 1, 0), Blocks.IRON_BLOCK);
        place(level, origin.offset(-1, 1, 0), Blocks.IRON_BLOCK);
        place(level, origin.offset(1, 2, 0), Blocks.IRON_BLOCK);
        place(level, origin.offset(-1, 2, 0), Blocks.IRON_BLOCK);

        player.sendSystemMessage(Component.literal(
            "Decorative rocket spawned. Flight, dimensions, and gravity are not implemented yet."
        ));
        return 1;
    }

    private static void place(net.minecraft.server.level.ServerLevel level, BlockPos pos,
                              net.minecraft.world.level.block.Block block) {
        level.setBlock(pos, block.defaultBlockState(), 3);
    }
}

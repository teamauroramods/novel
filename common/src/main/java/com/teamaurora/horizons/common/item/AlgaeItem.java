package com.teamaurora.horizons.common.item;


import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;

/**
 * @author JustinPlayzz
 * @author Steven
 * @author ebo2022
 */
public class AlgaeItem extends TabInsertBlockItem {
    public AlgaeItem(Block blockIn, Properties properties) { super(Blocks.GLOW_LICHEN.asItem(), blockIn, properties); }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        return InteractionResult.PASS;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        BlockHitResult blockraytraceresult = getPlayerPOVHitResult(worldIn, playerIn, ClipContext.Fluid.SOURCE_ONLY);
        BlockHitResult blockraytraceresult1 = blockraytraceresult.withPosition(blockraytraceresult.getBlockPos().above());
        InteractionResult actionresulttype = super.useOn(new UseOnContext(playerIn, handIn, blockraytraceresult1));
        return new InteractionResultHolder<>(actionresulttype, playerIn.getItemInHand(handIn));
    }
}
package net.mcreator.cheesemod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.cheesemod.item.CheesesliceItem;
import net.mcreator.cheesemod.CheesemodModElements;
import net.mcreator.cheesemod.CheesemodMod;

import java.util.Map;

@CheesemodModElements.ModElement.Tag
public class CheeseEat6Procedure extends CheesemodModElements.ModElement {
	public CheeseEat6Procedure(CheesemodModElements instance) {
		super(instance, 17);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CheesemodMod.LOGGER.warn("Failed to load dependency entity for procedure CheeseEat6!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CheesemodMod.LOGGER.warn("Failed to load dependency x for procedure CheeseEat6!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CheesemodMod.LOGGER.warn("Failed to load dependency y for procedure CheeseEat6!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CheesemodMod.LOGGER.warn("Failed to load dependency z for procedure CheeseEat6!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CheesemodMod.LOGGER.warn("Failed to load dependency world for procedure CheeseEat6!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (entity instanceof PlayerEntity) {
			ItemStack _setstack = new ItemStack(CheesesliceItem.block, (int) (1));
			_setstack.setCount((int) 1);
			ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
		}
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
	}
}

package net.mcreator.cheesemod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.cheesemod.item.CheesewheelItem;
import net.mcreator.cheesemod.block.CheeseWheel0Block;
import net.mcreator.cheesemod.CheesemodModElements;
import net.mcreator.cheesemod.CheesemodMod;

import java.util.Map;

@CheesemodModElements.ModElement.Tag
public class CheeseplaceProcedure extends CheesemodModElements.ModElement {
	public CheeseplaceProcedure(CheesemodModElements instance) {
		super(instance, 5);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CheesemodMod.LOGGER.warn("Failed to load dependency entity for procedure Cheeseplace!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CheesemodMod.LOGGER.warn("Failed to load dependency x for procedure Cheeseplace!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CheesemodMod.LOGGER.warn("Failed to load dependency y for procedure Cheeseplace!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CheesemodMod.LOGGER.warn("Failed to load dependency z for procedure Cheeseplace!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CheesemodMod.LOGGER.warn("Failed to load dependency world for procedure Cheeseplace!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (entity instanceof PlayerEntity) {
			ItemStack _stktoremove = new ItemStack(CheesewheelItem.block, (int) (1));
			((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
					((PlayerEntity) entity).container.func_234641_j_());
		}
		world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), CheeseWheel0Block.block.getDefaultState(), 3);
	}
}

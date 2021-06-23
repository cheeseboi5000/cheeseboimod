
package net.mcreator.cheesemod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.mcreator.cheesemod.CheesemodModElements;

@CheesemodModElements.ModElement.Tag
public class CheeseCurdItem extends CheesemodModElements.ModElement {
	@ObjectHolder("cheesemod:cheese_curd")
	public static final Item block = null;
	public CheeseCurdItem(CheesemodModElements instance) {
		super(instance, 26);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(8).rarity(Rarity.UNCOMMON)
					.food((new Food.Builder()).hunger(0).saturation(0.2f).setAlwaysEdible().build()));
			setRegistryName("cheese_curd");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 10;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}
	}
}

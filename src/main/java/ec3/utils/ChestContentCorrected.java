package ec3.utils;

import net.minecraft.item.Item;
import net.minecraft.util.WeightedRandomChestContent;

import java.util.Random;

public class ChestContentCorrected extends WeightedRandomChestContent {

    public ChestContentCorrected(Item item, int meta, int minChance, int maxChance, int weight) {
        super(item, meta, minChance, maxChance, weight);

        Random rand = new Random();

        int i1 = rand.nextInt(minChance) / 5;
        int i2 = rand.nextInt(maxChance) / 5;
        int i3 = Math.max(i1, i2);

        int l1 = rand.nextInt(weight) / 7;

        this.theMinimumChanceToGenerateItem = i3;
        this.theMaximumChanceToGenerateItem = i3;

        this.itemWeight = l1;
    }

}

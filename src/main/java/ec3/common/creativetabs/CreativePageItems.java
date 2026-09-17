package ec3.common.creativetabs;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ec3.common.init.ECItems;

/**
 * @version From DummyCore 1.0
 * @author Modbder
 *         Do not change anything here! Used to work with Items.
 */
public final class CreativePageItems extends CreativeTabs {

    private final String tabLabel;

    public CreativePageItems(String m) {
        super(m + " Items");
        tabLabel = m + " Items";
    }

    @Override
    public ItemStack getIconItemStack() {
        return new ItemStack(ECItems.research_book);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public String getTranslatedTabLabel() {
        return this.tabLabel;
    }

    @Override
    public Item getTabIconItem() {
        return ECItems.research_book;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void displayAllReleventItems(List list) {

        list.clear();

        List<ItemStack> manual = new ArrayList<ItemStack>();

        ECItems.research_book.getSubItems(ECItems.research_book, this, manual);
        manual.add(new ItemStack(ECItems.soulStone));
        manual.add(new ItemStack(ECItems.magicMonocle));
        manual.add(new ItemStack(ECItems.bound_gem));
        manual.add(new ItemStack(ECItems.inventoryGem));

        manual.add(new ItemStack(ECItems.mruMover1));
        manual.add(new ItemStack(ECItems.mruMover_t2));
        manual.add(new ItemStack(ECItems.magicalChisel));
        manual.add(new ItemStack(ECItems.controlRod));

        ECItems.drops.getSubItems(ECItems.drops, this, manual);

        manual.add(new ItemStack(ECItems.genericItem, 1, 1));

        manual.add(new ItemStack(ECItems.genericItem, 1, 21)); // diamond plating
        manual.add(new ItemStack(ECItems.genericItem, 1, 22));
        manual.add(new ItemStack(ECItems.genericItem, 1, 24));
        manual.add(new ItemStack(ECItems.genericItem, 1, 31));

        manual.add(new ItemStack(ECItems.genericItem, 1, 26));
        manual.add(new ItemStack(ECItems.genericItem, 1, 9));
        manual.add(new ItemStack(ECItems.genericItem, 1, 32));
        manual.add(new ItemStack(ECItems.genericItem, 1, 7));
        manual.add(new ItemStack(ECItems.genericItem, 1, 0));
        manual.add(new ItemStack(ECItems.genericItem, 1, 8));
        manual.add(new ItemStack(ECItems.genericItem, 1, 2));
        manual.add(new ItemStack(ECItems.genericItem, 1, 11));
        manual.add(new ItemStack(ECItems.genericItem, 1, 79));

        manual.add(new ItemStack(ECItems.genericItem, 1, 4));
        manual.add(new ItemStack(ECItems.genericItem, 1, 28));
        manual.add(new ItemStack(ECItems.genericItem, 1, 29));

        manual.add(new ItemStack(ECItems.genericItem, 1, 10));
        manual.add(new ItemStack(ECItems.genericItem, 1, 5));
        manual.add(new ItemStack(ECItems.genericItem, 1, 43));

        manual.add(new ItemStack(ECItems.genericItem, 1, 30));
        manual.add(new ItemStack(ECItems.genericItem, 1, 33));
        manual.add(new ItemStack(ECItems.genericItem, 1, 34));

        manual.add(new ItemStack(ECItems.genericItem, 1, 25));
        manual.add(new ItemStack(ECItems.genericItem, 1, 23));

        manual.add(new ItemStack(ECItems.genericItem, 1, 20));
        manual.add(new ItemStack(ECItems.genericItem, 1, 3));

        manual.add(new ItemStack(ECItems.genericItem, 1, 27));
        manual.add(new ItemStack(ECItems.genericItem, 1, 6));

        manual.add(new ItemStack(ECItems.magicalSlag));
        manual.add(new ItemStack(ECItems.genericItem, 1, 44));

        manual.add(new ItemStack(ECItems.genericItem, 1, 12)); // MRU gems
        manual.add(new ItemStack(ECItems.genericItem, 1, 13));
        manual.add(new ItemStack(ECItems.genericItem, 1, 14));
        manual.add(new ItemStack(ECItems.genericItem, 1, 15));
        manual.add(new ItemStack(ECItems.genericItem, 1, 16));

        manual.add(new ItemStack(ECItems.genericItem, 1, 42));

        manual.add(new ItemStack(ECItems.genericItem, 1, 38)); // pale items
        manual.add(new ItemStack(ECItems.genericItem, 1, 39));
        manual.add(new ItemStack(ECItems.genericItem, 1, 40));
        manual.add(new ItemStack(ECItems.genericItem, 1, 41));
        manual.add(new ItemStack(ECItems.genericItem, 1, 45));
        manual.add(new ItemStack(ECItems.genericItem, 1, 46));
        manual.add(new ItemStack(ECItems.genericItem, 1, 47));

        manual.add(new ItemStack(ECItems.genericItem, 1, 48)); // mithriline items
        manual.add(new ItemStack(ECItems.genericItem, 1, 49));
        manual.add(new ItemStack(ECItems.genericItem, 1, 50));
        manual.add(new ItemStack(ECItems.genericItem, 1, 51));

        manual.add(new ItemStack(ECItems.genericItem, 1, 55));

        ECItems.windTablet.getSubItems(ECItems.windTablet, this, manual);

        manual.add(new ItemStack(ECItems.bottledWind));
        manual.add(new ItemStack(ECItems.imprisonedWind));
        manual.add(new ItemStack(ECItems.windKeeper));

        manual.add(new ItemStack(ECItems.soulScriber));
        ECItems.soul.getSubItems(ECItems.soul, this, manual);

        manual.add(new ItemStack(ECItems.titanite));
        manual.add(new ItemStack(ECItems.twinkling_titanite));

        manual.add(new ItemStack(ECItems.genericItem, 1, 52));
        manual.add(new ItemStack(ECItems.genericItem, 1, 53));
        manual.add(new ItemStack(ECItems.genericItem, 1, 54));

        manual.add(new ItemStack(ECItems.genericItem, 1, 56));
        manual.add(new ItemStack(ECItems.genericItem, 1, 57));
        manual.add(new ItemStack(ECItems.genericItem, 1, 58));
        manual.add(new ItemStack(ECItems.genericItem, 1, 59));
        manual.add(new ItemStack(ECItems.genericItem, 1, 60));
        manual.add(new ItemStack(ECItems.genericItem, 1, 61));
        manual.add(new ItemStack(ECItems.genericItem, 1, 62));
        manual.add(new ItemStack(ECItems.genericItem, 1, 63));
        manual.add(new ItemStack(ECItems.genericItem, 1, 64));
        manual.add(new ItemStack(ECItems.genericItem, 1, 65));
        manual.add(new ItemStack(ECItems.genericItem, 1, 66));
        manual.add(new ItemStack(ECItems.genericItem, 1, 67));
        manual.add(new ItemStack(ECItems.genericItem, 1, 68));
        manual.add(new ItemStack(ECItems.genericItem, 1, 69));
        manual.add(new ItemStack(ECItems.genericItem, 1, 70));
        manual.add(new ItemStack(ECItems.genericItem, 1, 71));
        manual.add(new ItemStack(ECItems.genericItem, 1, 72));
        manual.add(new ItemStack(ECItems.genericItem, 1, 73));
        manual.add(new ItemStack(ECItems.genericItem, 1, 74));
        manual.add(new ItemStack(ECItems.genericItem, 1, 75));
        manual.add(new ItemStack(ECItems.genericItem, 1, 76));

        manual.add(new ItemStack(ECItems.genericItem, 1, 35));
        manual.add(new ItemStack(ECItems.genericItem, 1, 36));
        manual.add(new ItemStack(ECItems.genericItem, 1, 37));

        ECItems.magicalAlloy.getSubItems(ECItems.magicalAlloy, this, manual);

        ECItems.essence.getSubItems(ECItems.essence, this, manual);
        ECItems.elementalFuel.getSubItems(ECItems.elementalFuel, this, manual);
        manual.add(new ItemStack(ECItems.fFocus));
        manual.add(new ItemStack(ECItems.aFocus));
        manual.add(new ItemStack(ECItems.eFocus));
        manual.add(new ItemStack(ECItems.wFocus));
        ECItems.ember.getSubItems(ECItems.ember, this, manual);
        ECItems.charm.getSubItems(ECItems.charm, this, manual);

        ECItems.storage.getSubItems(ECItems.storage, this, manual);

        ECItems.emeraldHeart.getSubItems(ECItems.emeraldHeart, this, manual);
        ECItems.magicalShield.getSubItems(ECItems.magicalShield, this, manual);
        ECItems.spikyShield.getSubItems(ECItems.spikyShield, this, manual);
        ECItems.magicalWings.getSubItems(ECItems.magicalWings, this, manual);
        ECItems.magicWaterBottle.getSubItems(ECItems.magicWaterBottle, this, manual);
        manual.add(new ItemStack(ECItems.air_potion));
        ECItems.magicalPorkchop.getSubItems(ECItems.magicalPorkchop, this, manual);
        ECItems.matrixProj.getSubItems(ECItems.matrixProj, this, manual);

        ECItems.magicalDigger.getSubItems(ECItems.magicalDigger, this, manual);
        ECItems.spawnerCollector.getSubItems(ECItems.spawnerCollector, this, manual);
        ECItems.staffOfLife.getSubItems(ECItems.staffOfLife, this, manual);
        ECItems.biomeWand.getSubItems(ECItems.biomeWand, this, manual);
        ECItems.frozenMace.getSubItems(ECItems.frozenMace, this, manual);
        ECItems.holyMace.getSubItems(ECItems.holyMace, this, manual);
        ECItems.magmaticStaff.getSubItems(ECItems.magmaticStaff, this, manual);
        ECItems.magicalLantern.getSubItems(ECItems.magicalLantern, this, manual);
        ECItems.magnetizingStaff.getSubItems(ECItems.magnetizingStaff, this, manual);
        ECItems.chaosFork.getSubItems(ECItems.chaosFork, this, manual);
        ECItems.elementalSword.getSubItems(ECItems.elementalSword, this, manual);

        ECItems.magicalBuilder.getSubItems(ECItems.magicalBuilder, this, manual);

        ECItems.pistol.getSubItems(ECItems.pistol, this, manual);
        ECItems.rifle.getSubItems(ECItems.rifle, this, manual);
        ECItems.sniper.getSubItems(ECItems.sniper, this, manual);
        ECItems.gatling.getSubItems(ECItems.gatling, this, manual);

        manual.add(new ItemStack(ECItems.weak_elemental_sword));
        manual.add(new ItemStack(ECItems.weak_elemental_pick));
        manual.add(new ItemStack(ECItems.weak_elemental_axe));
        manual.add(new ItemStack(ECItems.weak_elemental_shovel));
        manual.add(new ItemStack(ECItems.weak_elemental_hoe));

        manual.add(new ItemStack(ECItems.elemental_sword));
        manual.add(new ItemStack(ECItems.elemental_pick));
        manual.add(new ItemStack(ECItems.elemental_axe));
        manual.add(new ItemStack(ECItems.elemental_shovel));
        manual.add(new ItemStack(ECItems.elemental_hoe));

        manual.add(new ItemStack(ECItems.wind_elemental_sword));
        manual.add(new ItemStack(ECItems.wind_elemental_pick));
        manual.add(new ItemStack(ECItems.wind_elemental_axe));
        manual.add(new ItemStack(ECItems.wind_elemental_shovel));
        manual.add(new ItemStack(ECItems.wind_elemental_hoe));

        manual.add(new ItemStack(ECItems.shadeKnife));
        manual.add(new ItemStack(ECItems.shadeSlasher));
        manual.add(new ItemStack(ECItems.shadeSword));

        for (int i = 0; i < ECItems.magicArmorItems.length; i++) {
            manual.add(new ItemStack(ECItems.magicArmorItems[i]));
        }

        manual.add(new ItemStack(ECItems.wind_helmet));
        manual.add(new ItemStack(ECItems.wind_chestplate));
        manual.add(new ItemStack(ECItems.wind_leggings));
        manual.add(new ItemStack(ECItems.wind_boots));

        manual.add(new ItemStack(ECItems.computer_helmet));
        manual.add(new ItemStack(ECItems.computer_chestplate));
        manual.add(new ItemStack(ECItems.computer_leggings));
        manual.add(new ItemStack(ECItems.computer_boots));

        manual.add(new ItemStack(ECItems.dividingGun));
        manual.add(new ItemStack(ECItems.orbitalRemote));
        manual.add(new ItemStack(ECItems.computerBoard));

        manual.add(new ItemStack(ECItems.genericItem, 1, 17));
        manual.add(new ItemStack(ECItems.genericItem, 1, 19));
        manual.add(new ItemStack(ECItems.genericItem, 1, 77));
        manual.add(new ItemStack(ECItems.genericItem, 1, 78));
        manual.add(new ItemStack(ECItems.genericItem, 1, 80));
        manual.add(new ItemStack(ECItems.genericItem, 1, 81));
        manual.add(new ItemStack(ECItems.genericItem, 1, 18));

        ECItems.filter.getSubItems(ECItems.filter, this, manual);
        manual.add(new ItemStack(ECItems.craftingFrame));
        manual.add(new ItemStack(ECItems.playerList));

        manual.add(new ItemStack(ECItems.bauble));
        ECItems.baublesCore.getSubItems(ECItems.baublesCore, this, manual);

        ECItems.entityEgg.getSubItems(ECItems.entityEgg, this, manual);
        manual.add(new ItemStack(ECItems.fruit));

        manual.add(new ItemStack(ECItems.record_robocalypse));
        manual.add(new ItemStack(ECItems.record_secret));
        manual.add(new ItemStack(ECItems.record_everlastingSummer));
        manual.add(new ItemStack(ECItems.record_papersPlease));
        ECItems.secret.getSubItems(ECItems.secret, this, manual);
        manual.add(new ItemStack(ECItems.testingItem));

        list.addAll(manual);

        List<ItemStack> defaultList = new ArrayList<ItemStack>();
        super.displayAllReleventItems(defaultList);

        for (ItemStack stack : defaultList) {
            boolean alreadyAdded = false;

            for (ItemStack manualStack : manual) {
                if (stack.getItem() == manualStack.getItem() && stack.getItemDamage() == manualStack.getItemDamage()) {
                    alreadyAdded = true;
                    break;
                }
            }

            if (!alreadyAdded) {
                list.add(stack);
            }

        }
    }
}

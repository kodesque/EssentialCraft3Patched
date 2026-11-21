package ec3.common.items;

import java.util.List;

import ec3.utils.dummycore.utils.BlockPos;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import ec3.common.init.ECBlocks;
import ec3.utils.ECUtils;
import ec3.utils.WindUtils;
import ec3.utils.dummycore.utils.math.MathUtils;

public class ItemWindTablet extends ItemStoresMRUInNBT {

    public static final String windName = "Owethanna Else Hugaida";
    public static final int maxRelations = 3500;

    // 24
    public static String[] windMessages = new String[] { "A wind blow rotates around you...", // 0
        "The wind howls...", // 1
        "The wind ruffles your hair...", // 2
        "The wind blows around your fingers...", // 3
        "The wind says something...", // 4
        "The wind makes you sneeze!", // 5
        "You hear something similar to laugh...", // 6
        "The wind rotates around your legs...", // 7
        "The wind tickles you...", // 8
        "The wind stops all other sounds...", // 9
        "The wind whispers 'Owethanna'...", // 10
        "The wind whispers your name...", // 11
        "The wind brings a very nostalgic smell...", // 12
        "The wind creates a miniature tornado...", // 13
        "The wind thows some leaves around...", // 14
        "The wind says 'Owethanna Else '...", // 15
        "The wind pushes you upwards...", // 16
        "The wind rotates very fast around you...", // 17
        "The wind goes into your lungs...", // 18
        "You feel very powerfull!", // 19
        "You fly up using the wind!", // 20
        "You start seeing other worlds!", // 21
        "You and the wind laugh...", // 22
        "The wind and you shout:"// 23
    };

    public ItemWindTablet() {
        super();
        this.setMaxMRU(5000);
        this.maxStackSize = 1;
        this.bFull3D = false;
    }



    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        if ((ECUtils.tryToDecreaseMRUInStorage(player, -500) || this.setMRU(stack, -500))) {
            int currentWindRev = WindUtils.getPlayerWindRelations(player);

            int revPos = MathUtils.pixelatedTextureSize(currentWindRev, maxRelations, windName.length());
            if (!world.isRemote && revPos >= 22) {

                Block block = world.getBlock(x, y, z);

                if (block.equals(Blocks.portal)) {

                    int meta = world.getBlockMetadata(x, y, z);

                    world.setBlock(x, y, z, ECBlocks.portal, meta, 1);
                    return true;
                }
            }
        }

        return false;
    }


    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
        int currentWindRev = WindUtils.getPlayerWindRelations(par2EntityPlayer);
        String hidden = "??????????????????????";
        int revPos = MathUtils.pixelatedTextureSize(currentWindRev, maxRelations, windName.length());
        par3List.add(new ChatComponentTranslation("ec3.txt.windTablet.name").getFormattedText());
        par3List.add(windName.substring(0, revPos) + hidden.substring(revPos));
    }

}

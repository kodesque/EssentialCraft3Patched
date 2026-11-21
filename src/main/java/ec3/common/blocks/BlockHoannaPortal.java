package ec3.common.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ec3.api.config.Config;

public class BlockHoannaPortal extends net.minecraft.block.BlockPortal {

    public BlockHoannaPortal() {
        super();
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
        return this.blockIcon;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_) {
        this.blockIcon = p_149651_1_.registerIcon(this.getTextureName());
    }

    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity player) {
        if (!world.isRemote) {
            if (player.dimension == Config.dimensionID) {
                player.travelToDimension(0);
            } else {
                player.travelToDimension(Config.dimensionID);
            }
        }
    }

    public void onNeighborBlockChange(World worldIn, int x, int y, int z, Block neighbor)
    {
        if (neighbor.equals(Blocks.portal)) {
            worldIn.setBlock(x, y, z, this);
        } else {
            super.onNeighborBlockChange(worldIn, x, y, z, neighbor);
        }
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {}

    public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {}
}

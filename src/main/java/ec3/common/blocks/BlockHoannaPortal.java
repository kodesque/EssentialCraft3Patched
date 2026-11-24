package ec3.common.blocks;

import java.util.Random;

import ec3.common.init.ECBlocks;
import ec3.root.EssentialCraftCore;
import ec3.utils.dummycore.utils.math.MathUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Direction;
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
        int portalDirection = func_149999_b(worldIn.getBlockMetadata(x, y, z));
        Size size = new Size(worldIn, x, y, z, 1);
        Size size1 = new Size(worldIn, x, y, z, 2);

        if (portalDirection == 1 && (!size.isValid() || size.portalBlockCount < size.width * size.height))
        {
            worldIn.setBlock(x, y, z, Blocks.air);
        }
        else if (portalDirection == 2 && (!size1.isValid() || size1.portalBlockCount < size1.width * size1.height))
        {
            worldIn.setBlock(x, y, z, Blocks.air);
        }
        else if (portalDirection == 0 && !size.isValid() && !size1.isValid())
        {
            worldIn.setBlock(x, y, z, Blocks.air);
        }
    }

    public static boolean makePortal(World world, int x, int y, int z)
    {
        Size size = new Size(world, x, y, z, 1);
        Size size1 = new Size(world, x, y, z, 2);

        if (size.isValid() && size.portalBlockCount == 0)
        {
            size.placePortalBlocks();
            return true;
        }
        else if (size1.isValid() && size1.portalBlockCount == 0)
        {
            size1.placePortalBlocks();
            return true;
        }
        else
        {
            return false;
        }
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random) {

            EssentialCraftCore.proxy.SmokeFX(
                x + 0.5D + MathUtils.randomDouble(world.rand) * 1.6D,
                y,
                z + 0.5D + MathUtils.randomDouble(world.rand) * 1.6D,
                0,
                world.rand.nextDouble() * 0.3D,
                0,
                1,
                0.2D,
                1.0D,
                0.45D
            );

    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z)
    {
            for (int i = 0; i < 20; i++) {
                EssentialCraftCore.proxy.SmokeFX(
                    x + 0.5D + MathUtils.randomDouble(world.rand) * 1.6D,
                    y,
                    z + 0.5D + MathUtils.randomDouble(world.rand) * 1.6D,
                    0,
                    world.rand.nextDouble() * 0.3D,
                    0,
                    1,
                    0.2D,
                    1.0D,
                    0.45D);
            }
    }



    public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {}

    public static class Size
    {
        private final World world;
        private final int portalDirection;
        private final int depthDirection;
        public final int widthDirection;
        private int portalBlockCount = 0;
        public ChunkCoordinates bottomLeft;
        public int height;
        public int width;
        private static final String __OBFID = "CL_00000285";

        public Size(World world, int x, int y, int z, int portalDirection)
        {
            this.world = world;
            this.portalDirection = portalDirection;
            this.depthDirection = BlockPortal.field_150001_a[portalDirection][0];
            this.widthDirection = BlockPortal.field_150001_a[portalDirection][1];

            for (int currentY = y; y > currentY - 21 && y > 0 && this.isEmptyBlock(world.getBlock(x, y - 1, z)); --y)
            {
                ;
            }

            int width = this.getDistanceUntilObsidian(x, y, z, this.depthDirection) - 1;

            if (width >= 0)
            {
                this.bottomLeft = new ChunkCoordinates(x + width * Direction.offsetX[this.depthDirection], y, z + width * Direction.offsetZ[this.depthDirection]);
                this.width = this.getDistanceUntilObsidian(this.bottomLeft.posX, this.bottomLeft.posY, this.bottomLeft.posZ, this.widthDirection);

                if (this.width < 2 || this.width > 21)
                {
                    this.bottomLeft = null;
                    this.width = 0;
                }
            }

            if (this.bottomLeft != null)
            {
                this.height = this.calculateHeight();
            }
        }

        protected int getDistanceUntilObsidian(int x, int y, int z, int direction)
        {
            int offsetX = Direction.offsetX[direction];
            int offsetZ = Direction.offsetZ[direction];
            int distance;
            Block block;

            for (distance = 0; distance < 22; ++distance)
            {
                block = this.world.getBlock(x + offsetX * distance, y, z + offsetZ * distance);

                if (!this.isEmptyBlock(block))
                {
                    break;
                }

                Block groundBlock = this.world.getBlock(x + offsetX * distance, y - 1, z + offsetZ * distance);

                if (groundBlock != Blocks.obsidian)
                {
                    break;
                }
            }

            block = this.world.getBlock(x + offsetX * distance, y, z + offsetZ * distance);
            return block == Blocks.obsidian ? distance : 0;
        }

        protected int calculateHeight()
        {
            int y;
            int x;
            int z;
            int heightIndex;
            label56:

            for (this.height = 0; this.height < 21; ++this.height)
            {
                y = this.bottomLeft.posY + this.height;

                for (x = 0; x < this.width; ++x)
                {
                    z = this.bottomLeft.posX + x * Direction.offsetX[BlockPortal.field_150001_a[this.portalDirection][1]];
                    heightIndex = this.bottomLeft.posZ + x * Direction.offsetZ[BlockPortal.field_150001_a[this.portalDirection][1]];
                    Block block = this.world.getBlock(z, y, heightIndex);

                    if (!this.isEmptyBlock(block))
                    {
                        break label56;
                    }

                    if (block == Blocks.portal || block == ECBlocks.portal)
                    {
                        ++this.portalBlockCount;
                    }

                    if (x == 0)
                    {
                        block = this.world.getBlock(z + Direction.offsetX[BlockPortal.field_150001_a[this.portalDirection][0]], y, heightIndex + Direction.offsetZ[BlockPortal.field_150001_a[this.portalDirection][0]]);

                        if (block != Blocks.obsidian)
                        {
                            break label56;
                        }
                    }
                    else if (x == this.width - 1)
                    {
                        block = this.world.getBlock(z + Direction.offsetX[BlockPortal.field_150001_a[this.portalDirection][1]], y, heightIndex + Direction.offsetZ[BlockPortal.field_150001_a[this.portalDirection][1]]);

                        if (block != Blocks.obsidian)
                        {
                            break label56;
                        }
                    }
                }
            }

            for (x = 0; x < this.width; ++x)
            {
                z = this.bottomLeft.posX + x * Direction.offsetX[BlockPortal.field_150001_a[this.portalDirection][1]];
                y = this.bottomLeft.posY + this.height;
                heightIndex = this.bottomLeft.posZ + x * Direction.offsetZ[BlockPortal.field_150001_a[this.portalDirection][1]];

                if (this.world.getBlock(z, y, heightIndex) != Blocks.obsidian)
                {
                    this.height = 0;
                    break;
                }
            }

            if (this.height <= 21 && this.height >= 3)
            {
                return this.height;
            }
            else
            {
                this.bottomLeft = null;
                this.width = 0;
                this.height = 0;
                return 0;
            }
        }

        protected boolean isEmptyBlock(Block block)
        {
            return block.getMaterial() == Material.air || block == Blocks.fire || block == Blocks.portal || block == ECBlocks.portal;
        }

        public boolean isValid()
        {
            return this.bottomLeft != null && this.width >= 2 && this.width <= 21 && this.height >= 3 && this.height <= 21;
        }

        public void placePortalBlocks()
        {
            for (int widthIndex = 0; widthIndex < this.width; ++widthIndex)
            {
                int x = this.bottomLeft.posX + Direction.offsetX[this.widthDirection] * widthIndex;
                int z = this.bottomLeft.posZ + Direction.offsetZ[this.widthDirection] * widthIndex;

                for (int heightIndex = 0; heightIndex < this.height; ++heightIndex)
                {
                    int y = this.bottomLeft.posY + heightIndex;
                    this.world.setBlock(x, y, z, ECBlocks.portal, this.portalDirection, 2);
                }
            }
        }
    }
}

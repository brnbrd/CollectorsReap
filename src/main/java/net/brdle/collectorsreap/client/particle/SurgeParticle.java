package net.brdle.collectorsreap.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class SurgeParticle extends TextureSheetParticle {
	SurgeParticle(ClientLevel level, double x, double y, double z) {
		super(level, x, y, z, 0D, 0D, 0D);
		this.quadSize *= 0.75F;
		this.lifetime = Math.max((int)(6.0D / (Math.random() * 0.8D + 0.6D)), 1);
		this.hasPhysics = false;
	}

	@Override
	public @NotNull ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}

	@OnlyIn(Dist.CLIENT)
	public static class Provider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet sprite;

		public Provider(SpriteSet sprites) {
			this.sprite = sprites;
		}

		@Override
		public @Nullable Particle createParticle(@NotNull SimpleParticleType type, @NotNull ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			SurgeParticle surge = new SurgeParticle(level, x, y, z);
			surge.pickSprite(this.sprite);
			return surge;
		}
	}
}
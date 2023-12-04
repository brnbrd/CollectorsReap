package net.brdle.collectorsreap.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.brdle.collectorsreap.client.animation.TigerPrawnAnimation;
import net.brdle.collectorsreap.common.entity.TigerPrawn;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import org.jetbrains.annotations.NotNull;

public class TigerPrawnModel extends HierarchicalModel<TigerPrawn> {
	private final ModelPart body;
	private final ModelPart bone;
	private final ModelPart frontLegs;
	private final ModelPart tail1;
	private final ModelPart smallLegs;
	private final ModelPart tail2;
	private final ModelPart tailTip;


	public TigerPrawnModel(ModelPart root) {
		super(RenderType::entityCutoutNoCull);
		this.body = root.getChild("Whole");
		this.bone = this.body.getChild("bone");
		this.frontLegs = this.body.getChild("FrontLegs");
		this.tail1 = this.body.getChild("Tail1");
		this.smallLegs = this.tail1.getChild("SmallLegs");
		this.tail2 = this.tail1.getChild("Tail2");
		this.tailTip = this.tail2.getChild("TailTip");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition root = meshdefinition.getRoot();
		PartDefinition body = root.addOrReplaceChild("Whole", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.0F, -14.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 8).addBox(-2.0F, -1.0F, -12.0F, 4.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, 1.0F));
		PartDefinition bone = body.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, 0.0F, -2.0F, 10.0F, 0.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -12.0F, -0.0873F, 0.0F, 0.0F));
		PartDefinition FrontLegs = body.addOrReplaceChild("FrontLegs", CubeListBuilder.create().texOffs(16, 20).addBox(-1.5F, 0.0F, -3.0F, 0.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(11, 14).addBox(1.5F, 0.0F, -3.0F, 0.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, -8.0F));
		PartDefinition Tail1 = body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(19, 17).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -3.0F, -0.1309F, 0.0F, 0.0F));
		PartDefinition SmallLegs = Tail1.addOrReplaceChild("SmallLegs", CubeListBuilder.create().texOffs(0, 24).addBox(-1.0F, 0.0F, -2.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-3.0F, 0.0F, -2.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 3.0F, 3.0F));
		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(0, 21).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(0.0F, 0.0F, 7.0F, -0.3054F, 0.0F, 0.0F));
		PartDefinition TailTip = Tail2.addOrReplaceChild("TailTip", CubeListBuilder.create().texOffs(0, 4).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 5.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public @NotNull ModelPart root() {
		return body;
	}

	@Override
	public void setupAnim(@NotNull TigerPrawn entity, float limbSwing, float limbSwingAmount, float age, float netHeadYaw, float headPitch) {
		/*float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}
		this.tail1.yRot = -f * 0.45F * Mth.sin(0.6F * age);
		 */
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animate(entity.swimAnimationState, TigerPrawnAnimation.MODEL_SWIM, age);
		this.animate(entity.drownAnimationState, TigerPrawnAnimation.MODEL_DROWN, age);
	}
}
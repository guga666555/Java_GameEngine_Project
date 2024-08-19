package models;

import textures.ModelTexture;

public class TexturedModel {
    private RawModel rawModel;

    public RawModel getRawModel() {
        return rawModel;
    }

    public void setRawModel(RawModel rawModel) {
        this.rawModel = rawModel;
    }

    private ModelTexture modelTexture;

    public ModelTexture getModelTexture() {
        return modelTexture;
    }

    public void setModelTexture(ModelTexture modelTexture) {
        this.modelTexture = modelTexture;
    }

    public TexturedModel(RawModel rawModel, ModelTexture modelTexture) {
        this.rawModel = rawModel;
        this.modelTexture = modelTexture;
    }
}

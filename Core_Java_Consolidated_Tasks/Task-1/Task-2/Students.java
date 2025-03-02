public class Students {
    private String studName;
    private float maths;
    private float physics;
    private float chemistry;
    
    public float getTotal() {
        return maths + physics + chemistry;
    }

    public float getAverage() {
        return getTotal() / 3;
    }

    public Students(String studName, float maths, float physics, float chemistry) {
        this.studName = studName;
        this.maths = maths;
        this.physics = physics;
        this.chemistry = chemistry;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public float getMaths() {
        return maths;
    }

    public void setMaths(float maths) {
        this.maths = maths;
    }

    public float getPhysics() {
        return physics;
    }

    public void setPhysics(float physics) {
        this.physics = physics;
    }

    public float getChemistry() {
        return chemistry;
    }

    public void setChemistry(float chemistry) {
        this.chemistry = chemistry;
    }
}
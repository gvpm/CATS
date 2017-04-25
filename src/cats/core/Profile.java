package cats.core;

import cats.fdps.FDPProviderFactory;
import cats.fdps.FDPProvider;

/**
 * Responsible to store all the profiles information. Core will have an
 * arrayList of profiles.
 *
 * @author
 */
public class Profile {

    FDPProvider fdpProvider;
    String name;
    int size;
    int velMax;
    int ahead;
    int safeDistance;
    int velIncrement;
    double percentageOccurrence;
    float alphaAcc;
    float betaAcc;
    float alphaAnt;
    float betaAnt;

    public Profile(String fdpProvider, String name, int size, int velMax, int ahead, int safeDistance, int velIncrement, double percentageOccurrence, float alphaAcc, float betaAcc, float alphaAnt, float betaAnt) {
        FDPProviderFactory fdpFactory = new FDPProviderFactory();
        this.fdpProvider = fdpFactory.fabricate(fdpProvider);
        this.name = name;
        this.size = size;
        this.velMax = velMax;
        this.ahead = ahead;
        this.safeDistance = safeDistance;
        this.velIncrement = velIncrement;
        this.percentageOccurrence = percentageOccurrence;
        this.alphaAcc = alphaAcc;
        this.betaAcc = betaAcc;
        this.alphaAnt = alphaAnt;
        this.betaAnt = betaAnt;
    }

    public FDPProvider getFdpProvider() {
        return fdpProvider;
    }

    public void setFdpProvider(FDPProvider fdpProvider) {
        this.fdpProvider = fdpProvider;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getVelMax() {
        return velMax;
    }

    public void setVelMax(int velMax) {
        this.velMax = velMax;
    }

    public int getAhead() {
        return ahead;
    }

    public void setAhead(int ahead) {
        this.ahead = ahead;
    }

    public int getSafeDistance() {
        return safeDistance;
    }

    public void setSafeDistance(int safeDistance) {
        this.safeDistance = safeDistance;
    }

    public int getVelIncrement() {
        return velIncrement;
    }

    public void setVelIncrement(int velIncrement) {
        this.velIncrement = velIncrement;
    }

    public double getPercentageOccurrence() {
        return percentageOccurrence;
    }

    public void setPercentageOccurrence(int percentageOccurrence) {
        this.percentageOccurrence = percentageOccurrence;
    }

    public float getAlphaAcc() {
        return alphaAcc;
    }

    public void setAlphaAcc(float alphaAcc) {
        this.alphaAcc = alphaAcc;
    }

    public float getBetaAcc() {
        return betaAcc;
    }

    public void setBetaAcc(float betaAcc) {
        this.betaAcc = betaAcc;
    }

    public float getAlphaAnt() {
        return alphaAnt;
    }

    public void setAlphaAnt(float alphaAnt) {
        this.alphaAnt = alphaAnt;
    }

    public float getBetaAnt() {
        return betaAnt;
    }

    public void setBetaAnt(float betaAnt) {
        this.betaAnt = betaAnt;
    }

    @Override
    public String toString() {

        return getName() + " Occurrence: " + getPercentageOccurrence() + " Size: " + getSize() + " FDPProvider: " + this.getFdpProvider().toString();
    }

}

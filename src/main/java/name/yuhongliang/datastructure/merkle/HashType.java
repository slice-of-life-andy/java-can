package name.yuhongliang.datastructure.merkle;

/**
 * Created by andy on 16-9-21.
 */
/**
 * Enumeration used to define what hash type the merkle tree is using
 * @author noahmalmed
 *
 */
public enum HashType {
    SHA256,     // Used for all merkle's outside of bitcoin
    DOUBLE_SHA256   // Used for merkle's inside of bitcoin
}

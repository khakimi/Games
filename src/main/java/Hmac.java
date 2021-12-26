import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacUtils;
import java.security.SecureRandom;
import java.util.Arrays;

import static org.apache.commons.codec.digest.HmacAlgorithms.HMAC_SHA_256;
import static org.apache.commons.codec.digest.MessageDigestAlgorithms.SHA_256;

public class Hmac {
    private final String key;
    private final String hmac;


    public Hmac(long move, String message){
        key = new DigestUtils(SHA_256).digestAsHex(Long.toString(move));
        hmac = Hex.encodeHexString((new HmacUtils(HMAC_SHA_256, key).hmac(message)));
    }

    public String getKey() {
        return key;
    }

    public String getHmac() {
        return hmac;
    }

}

import com.github.freva.asciitable.AsciiTable;
import org.apache.commons.codec.Encoder;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacUtils;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        SecureRandom secureRandom = new SecureRandom();
        byte []bytes = new byte[32];
        var key = secureRandom.nextLong();
        System.out.println(key%7);
        var hashKey = DigestUtils.sha256(bytes);
        System.out.println(Hex.decode(hashKey));
        System.out.println("05D447E006BB8A06565338D411");
        //var hmac = hmacUtil.hmac(message, hashKey, algoritm);
        secureRandom.nextBytes(bytes);
        //System.out.println(String.format("%04X", key));

        System.out.println(Hex.);
        Game game = new Game(args);
        //game.printRuleTable();
        System.out.println(game.playGame(1));
    }
}
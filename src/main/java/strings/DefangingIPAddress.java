package strings;

public class DefangingIPAddress {
    /*
    Given a valid (IPv4) IP address, return a defanged version of that IP address.

    A defanged IP address replaces every period "." with "[.]".
     */

    public static String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }
}

/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */
         
// MESSAGE RC_CHANNELS_OVERRIDE PACKING
package com.MAVLink.common;
import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Parser;
import com.MAVLink.ardupilotmega.CRC;
import java.nio.ByteBuffer;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
* The RAW values of the RC channels sent to the MAV to override info received from the RC radio. A value of UINT16_MAX means no change to that channel. A value of 0 means control of that channel should be released back to the RC radio. The standard PPM modulation is as follows: 1000 microseconds: 0%, 2000 microseconds: 100%. Individual receivers/transmitters might violate this specification.
*/
public class msg_rc_channels_override_test{

public static final int MAVLINK_MSG_ID_RC_CHANNELS_OVERRIDE = 70;
public static final int MAVLINK_MSG_LENGTH = 18;
private static final long serialVersionUID = MAVLINK_MSG_ID_RC_CHANNELS_OVERRIDE;

private Parser parser = new Parser();

public CRC generateCRC(byte[] packet){
    CRC crc = new CRC();
    for (int i = 1; i < packet.length - 2; i++) {
        crc.update_checksum(packet[i] & 0xFF);
    }
    crc.finish_checksum(MAVLINK_MSG_ID_RC_CHANNELS_OVERRIDE);
    return crc;
}

public byte[] generateTestPacket(){
    ByteBuffer payload = ByteBuffer.allocate(6 + MAVLINK_MSG_LENGTH + 2);
    payload.put((byte)MAVLinkPacket.MAVLINK_STX); //stx
    payload.put((byte)MAVLINK_MSG_LENGTH); //len
    payload.put((byte)0); //seq
    payload.put((byte)255); //sysid
    payload.put((byte)190); //comp id
    payload.put((byte)MAVLINK_MSG_ID_RC_CHANNELS_OVERRIDE); //msg id
    payload.putShort((short)17235); //chan1_raw
    payload.putShort((short)17339); //chan2_raw
    payload.putShort((short)17443); //chan3_raw
    payload.putShort((short)17547); //chan4_raw
    payload.putShort((short)17651); //chan5_raw
    payload.putShort((short)17755); //chan6_raw
    payload.putShort((short)17859); //chan7_raw
    payload.putShort((short)17963); //chan8_raw
    payload.put((byte)53); //target_system
    payload.put((byte)120); //target_component
    
    CRC crc = generateCRC(payload.array());
    payload.put((byte)crc.getLSB());
    payload.put((byte)crc.getMSB());
    return payload.array();
}

@Test
public void test(){
    byte[] packet = generateTestPacket();
    for(int i = 0; i < packet.length - 1; i++){
        parser.mavlink_parse_char(packet[i] & 0xFF);
    }
    MAVLinkPacket m = parser.mavlink_parse_char(packet[packet.length - 1] & 0xFF);
    byte[] processedPacket = m.encodePacket();
    assertArrayEquals("msg_rc_channels_override", processedPacket, packet);
}
}
        
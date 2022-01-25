package in.as.sixtynine.rakku.services;

import in.as.sixtynine.rakku.entities.OTP;
import in.as.sixtynine.rakku.repositories.OTPRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Author Sanjay Das (s0d062y), Created on 23/01/22
 */


@Service
@Log4j2
@RequiredArgsConstructor
public class MessageSenderService {
    private final OTPRepository otpRepository;

    @Value("${otp.ttl:300}")
    private Long otpTtl;

    public void sendSms(long phoneNumber, int generatedTOTP, String s) {
        log.info("Mobile No: {}, MSG: {}", phoneNumber, s);
        OTP otp = new OTP();
        otp.setOtp(String.valueOf(generatedTOTP));
        otp.setTtl(otpTtl);
        otp.setMobileNo(String.valueOf(phoneNumber));
        otpRepository.save(otp);
    }
}

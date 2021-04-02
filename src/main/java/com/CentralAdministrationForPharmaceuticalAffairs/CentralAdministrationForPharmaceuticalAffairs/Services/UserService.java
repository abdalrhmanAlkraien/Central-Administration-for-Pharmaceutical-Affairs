package com.CentralAdministrationForPharmaceuticalAffairs.CentralAdministrationForPharmaceuticalAffairs.Services;

import com.CentralAdministrationForPharmaceuticalAffairs.CentralAdministrationForPharmaceuticalAffairs.Entity.User;
import com.CentralAdministrationForPharmaceuticalAffairs.CentralAdministrationForPharmaceuticalAffairs.HelpClass.Login;
import com.CentralAdministrationForPharmaceuticalAffairs.CentralAdministrationForPharmaceuticalAffairs.HelpClass.PasswordUtils;
import com.CentralAdministrationForPharmaceuticalAffairs.CentralAdministrationForPharmaceuticalAffairs.Repostory.UserRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
public class UserService {
    private final UserRepostory userRepostory;

    @Autowired
    public UserService(UserRepostory userRepostory) {
        this.userRepostory = userRepostory;
    }

    public User createUser(User user) throws Exception {
        try {
            if (!user.validation().equals("")) {
                throw new Exception(user.validation());
            }
            String salt = PasswordUtils.getSalt(30);
            // Protect user's password. The generated value can be stored in DB.
            String encryptPassword = PasswordUtils.generateSecurePassword(user.getPassword(), salt);
            user.setPassword(encryptPassword);
            user.setSalt(salt);
            return userRepostory.save(user);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // create token if user is exist and match password in db else return exception
    public User createToken(Login login) throws Exception {

        try {

            if (userRepostory.findByEmail(login.getEmail()).isPresent()) {

                User user = userRepostory.findByEmail(login.getEmail()).get();
                String salt = PasswordUtils.getSalt(30);
                // Protect user's password. The generated value can be stored in DB.
                String encryptPassword = PasswordUtils.generateSecurePassword(login.getPassword(), salt);
                if(PasswordUtils.verifyUserPassword(login.getPassword(),user.getPassword(),user.getSalt()))
                {
                    user.setCreatedAt(Instant.now());
                    generateToken(user);
                    return userRepostory.save(user);
                }
                else {
                    throw new Exception("Password is Wrong");
                }
            } else {
                throw new Exception("user does not exist");
            }
        } catch (NoSuchElementException e) {

            throw new Exception("user does not exist");
        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }

    }

    //method for Generate Token call from create token method
    public void generateToken(User user) {
        Random random = new Random();
        long longToken = Math.abs(random.nextLong());
        String rand = Long.toString(longToken, 16);
        user.setToken(user.getFirstName() + ":" + rand);
    }

}

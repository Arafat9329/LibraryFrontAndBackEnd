package javaInterviewCoding.day02;

/*
1. Write a return method that can verify if a password is valid or not.

requirements:

 1. Password MUST be at least have 6 characters and should not contain space

2. PassWord should at least contain one upper case letter

3. PassWord should at least contain one lowercase letter

4. Password should at least contain one special characters

5. Password should at least contain a digit
 */


public class PasswordValidationTask {

    public static void main(String[] args) {
        String str ="4a56@6321A%";

        String specialchars="(.*[ -/, :-@].*)";
        boolean specialchars2 =false;
        boolean strLength = false;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasSpecialChar = str.matches(specialchars);
        boolean hasNumber = false;


        if (str.length()>=6){
            System.out.println(str.length());
            strLength=true;

            for (int i = 0; i <str.length() ; i++) {
                if (str.charAt(i)>='A' && str.charAt(i)<='Z'){
                    System.out.println("uper pass");
                    hasUpperCase=true;
                }

                if (str.charAt(i)>='a' && str.charAt(i)<='z'){


                    hasLowerCase=true;
                }

                if (str.charAt(i)>='0' && str.charAt(i)<='9'){

                    hasNumber=true;
                }

            }

            for (char each :str.toCharArray()) {
                if (!Character.isLetterOrDigit(each)){
                    specialchars2=true;
                }
            }

            }

        if (strLength && hasLowerCase && hasUpperCase && specialchars2 && hasNumber){
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }


        char test ='*';

        System.out.println("Character.isSpaceChar(test) = " + !Character.isLetterOrDigit(test));


    }

    public static boolean PassWordvalidation(String password) {

        String lowercase="(.*[a-z].*)";
        String uppercase="(.*[A-Z].*)";
        String numbers="(.*[0-9].*)";
        String specialchars="(.*[ -/, :-@].*)";



        boolean HasLower = password.matches(lowercase),
                HasUppere = password.matches(uppercase),
                HasDigits = password.matches(numbers),
                HasSpecial = password.matches(specialchars),
                Valid = false;



        if(password.length() >= 6 && !password.contains(" "))
            if( HasLower && HasUppere && HasDigits && HasSpecial)
                Valid = true;
        return Valid;
    }

    }


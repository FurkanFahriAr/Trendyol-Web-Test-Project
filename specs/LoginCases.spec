Login Cases
===========
Created by furkanfahriar on 2019-02-27

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.
     
Valid Login
------------
*CLICK CLOSE BUTTON OPENED POPUP
*CLICK LOGIN BUTTON ON THE HOMEPAGE
*ENTER EMAIL FIELD "furkanfahriar@outlook.com" ON THE POP UP PAGE
*ENTER PASSWORD FIELD "Aa123456" ON THE POP UP PAGE
*CLICK LOGIN BUTTON ON THE POP UP PAGE
*USER MUST HAVE LOGGED IN TO THE WEBSITE

InValid Login Email Format Error
--------------------------------
*CLICK CLOSE BUTTON OPENED POPUP
*CLICK LOGIN BUTTON ON THE HOMEPAGE
*ENTER PASSWORD FIELD "Aa123456" ON THE POP UP PAGE
*ENTER INVALID EMAILS IN THE FIELD AND CLICK LOGIN BUTTON
     |Email|Error|
     |user@example,com|Lütfen email adresinizi giriniz.|
     |user_at_foo.org|Lütfen email adresinizi giriniz.|
     |user.name@example.|Lütfen email adresinizi giriniz.|
     |foo@bar_baz.com|Lütfen email adresinizi giriniz.|
     |foo@bar+baz.com|Lütfen email adresinizi giriniz.|
     |foo@bar..com|Lütfen email adresinizi giriniz.|
     |spencer@.com|Lütfen email adresinizi giriniz.|
     |email@domain@domain.com|Lütfen email adresinizi giriniz.|
     |.email@domain.com|Lütfen email adresinizi giriniz.|
     |email.@domain.com|Lütfen email adresinizi giriniz.|
     |email..email@domain.com|Lütfen email adresinizi giriniz.|
     |email@domain.com (Joe Smith)|Lütfen email adresinizi giriniz.|
     |email@domain|Lütfen email adresinizi giriniz.|
     |email@-domain.com|Lütfen email adresinizi giriniz.|
     |email@-domain.com|Lütfen email adresinizi giriniz.|
     |email@domain..com|Lütfen email adresinizi giriniz.|
     |user@example.com|Hatalı E-Posta / Şifre. Tekrar Deneyin.|
     |USER@foo.COM|Hatalı E-Posta / Şifre. Tekrar Deneyin.|
     |A_US-ER@foo.bar.org|Hatalı E-Posta / Şifre. Tekrar Deneyin.|
     |first.last@foo.jp|Hatalı E-Posta / Şifre. Tekrar Deneyin.|
     |alice+bob@baz.cn|Hatalı E-Posta / Şifre. Tekrar Deneyin.|
     |b@jared.com|Hatalı E-Posta / Şifre. Tekrar Deneyin.|
     |me@c9.com|Hatalı E-Posta / Şifre. Tekrar Deneyin.|
     |email@domain.com|Hatalı E-Posta / Şifre. Tekrar Deneyin.|
     |firstname.lastname@domain.com|Hatalı E-Posta / Şifre. Tekrar Deneyin.|
     |email@subdomain.domain.com|Hatalı E-Posta / Şifre. Tekrar Deneyin.|
     |firstname+lastname@domain.com|Hatalı E-Posta / Şifre. Tekrar Deneyin.|
     |email@123.123.123.123|Hatalı E-Posta / Şifre. Tekrar Deneyin.|
     |1234567890@domain.com|Hatalı E-Posta / Şifre. Tekrar Deneyin.|
     |email@domain-one.com|Hatalı E-Posta / Şifre. Tekrar Deneyin.|
     |_______@domain.com|Hatalı E-Posta / Şifre. Tekrar Deneyin.|
     |email@domain.name|Hatalı E-Posta / Şifre. Tekrar Deneyin.|
     |email@domain.co.jp|Hatalı E-Posta / Şifre. Tekrar Deneyin.|
     |firstname-lastname@domain.com|Hatalı E-Posta / Şifre. Tekrar Deneyin.|
     
InValid Login Password Empty
----------------------------
*CLICK CLOSE BUTTON OPENED POPUP
*CLICK LOGIN BUTTON ON THE HOMEPAGE
*ENTER EMAIL FIELD "furkanfahriar@outlook.com" ON THE POP UP PAGE
*CLICK LOGIN BUTTON ON THE POP UP PAGE
*VERIFY THAT "Lütfen şifre giriniz." ERROR


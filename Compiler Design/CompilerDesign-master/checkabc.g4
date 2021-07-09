grammar checkabc;

s returns [Boolean value]
:aval=a bval=b cval=c
{$value=($aval.value==$bval.value && $bval.value==$cval.value);System.out.println("Syntactically correct and expression is "+$value);};

a returns [Integer value]
:(A)aval=a {$value=1+$aval.value;}
|A {$value=1;};

b returns [Integer value]
:(B)bval=b {$value=1+$bval.value;}
|B {$value=1;};

c returns [Integer value]
:(C)cval=c {$value=1+$cval.value;}
|C {$value=1;};

A:'a';
B:'b';
C:'c';
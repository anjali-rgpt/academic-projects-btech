grammar bintodec;

num returns [Integer value]
:l=left
{$value=$l.value;
System.out.println("Syntactically correct.");
System.out.println("Decimal:"+$value);

};

left returns [Integer value]
:l=left b=bit
{
$value=(2*$l.value)+$b.value;

}
| b=bit{$value=$b.value;

};

bit returns [Integer value]
: ZERO {$value=0;}
| ONE {$value=1;};

ONE:'1';
ZERO:'0';
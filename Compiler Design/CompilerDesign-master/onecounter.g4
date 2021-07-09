grammar onecounter;

num returns [Integer value]
:n=left
{$value=$n.value;
System.out.println("Syntactically correct.");
System.out.println("Count of ones:"+$value);

};

left returns [Integer value]
:l=left b=bit
{
$value=$l.value+$b.value;

}
| b=bit{$value=$b.value;

};

bit returns [Integer value]
: ZERO {$value=0;}
| ONE {$value=1;};

ONE:'1';
ZERO:'0';
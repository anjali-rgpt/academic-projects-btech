grammar zerocounter;

num returns [Integer value]
:n=left
{$value=$n.value;
System.out.println("Syntactically correct.");
System.out.println("Count of zeroes:"+$value);

};

left returns [Integer value]
:l=left b=bit
{
$value=$l.value+$b.value;

}
| b=bit{$value=$b.value;

};

bit returns [Integer value]
: ZERO {$value=1;}
| ONE {$value=0;};

ONE:'1';
ZERO:'0';
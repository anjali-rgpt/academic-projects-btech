grammar bitcounter;

num returns [Integer value]
:n=left
{$value=$n.zerocount + $n.onecount;
System.out.println("Syntactically correct.");
System.out.println("Onecount:"+$n.onecount);
System.out.println("Zerocount:"+$n.zerocount);
System.out.println("Count of bits:"+$value);


};

left returns [Integer zerocount, Integer onecount]
:l=left b=bit
{
$zerocount=$l.zerocount+$b.zerocount;
$onecount=$l.onecount+$b.onecount;

}
| b=bit{$zerocount=$b.zerocount;
	$onecount=$b.onecount;

};

bit returns [Integer zerocount, Integer onecount]
: ZERO {$zerocount=1;$onecount=0;}
| ONE {$onecount=1;$zerocount=0;};

ONE:'1';
ZERO:'0';
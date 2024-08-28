public int compareTo(Course other)
{
if (other == null) return -1;
  if (this.getDept().compareTo(other.getDept())<0) return -1;
  if(this.getDept() == other.getDept())
  {
    if(this.getNum() == other.getNum()) return 0;
    if(this.getNum() > other.getNum()) return 1;
    if(this.getNum() < other.getNum()) return -1;
  }
  return 1;
}


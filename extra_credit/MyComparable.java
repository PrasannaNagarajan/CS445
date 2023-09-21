public interface MyComparable
{
	// return 0 if this identical char for char to other
	// return -1 if this lexically less than other
	// return 1 if this lexically greater than other
	public int myCompareTo( MyString other );
}
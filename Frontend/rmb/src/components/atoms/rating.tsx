interface RatingProp {
  rating?: number;
}
// The rating component
const Rating = ({ rating }: RatingProp) => {
  return <p>{rating}</p>;
};

export default Rating;

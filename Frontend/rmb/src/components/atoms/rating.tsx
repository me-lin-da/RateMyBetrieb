interface RatingProp {
  rating?: number;
}

const Rating = ({ rating }: RatingProp) => {
  return <p>{rating}</p>;
};

export default Rating;

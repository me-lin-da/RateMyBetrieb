interface TitleProps {
  companyName?: string;
  description?: string;
}

const Title = ({ companyName, description }: TitleProps) => {
  return (
    <div className="m-auto items-center">
      <h2 className="text-6xl font-bold">{companyName}</h2>
      <p>{description}</p>
    </div>
  );
};

export default Title;
